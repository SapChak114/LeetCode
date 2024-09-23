class Solution {
    public List<String> topKFrequent(String[] words, int k) {
Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a priority queue (min-heap) to store the top k frequent words
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> 
            freq.get(a).equals(freq.get(b)) ? b.compareTo(a) : freq.get(a) - freq.get(b)
        );

        // Step 3: Keep only the top k elements in the heap
        for (String word : freq.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll(); // Remove the least frequent element
            }
        }

        // Step 4: Extract the elements from the heap and build the result list
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        // Step 5: Reverse the list because it's in ascending order, but we need descending order
        Collections.reverse(result);

        return result;
    }
}