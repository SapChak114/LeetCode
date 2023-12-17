import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FoodRatings {
    Map<String, Integer> map;
    Map<String, PriorityQueue<FoodInfo>> cuisineMap;
    String[] cuisines;
    Map<String, Integer> foodMap;

    class FoodInfo {
        String food;
        int rating;

        public FoodInfo(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        cuisineMap = new HashMap<>();
        this.cuisines = cuisines;
        foodMap = new HashMap<>();

        int n = foods.length;
        for (int i = 0; i < n; i++) {
            foodMap.put(foods[i], ratings[i]);
            map.put(foods[i], i);
            String cuisine = cuisines[i];
            cuisineMap.putIfAbsent(cuisine, new PriorityQueue<>((a, b) -> {
                if (a.rating != b.rating) return Integer.compare(b.rating, a.rating);
                return a.food.compareTo(b.food);
            }));
            cuisineMap.get(cuisine).add(new FoodInfo(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) { // log(N)
        foodMap.put(food, newRating);
        int index = map.get(food);
        String cuisine = cuisines[index];

        // Remove the old foodInfo from the priority queue
        // cuisineMap.get(cuisine).removeIf(foodInfo -> foodInfo.food.equals(food));

        // Add the updated foodInfo to the priority queue
        cuisineMap.get(cuisine).add(new FoodInfo(food, newRating));
    }

    public String highestRated(String cuisine) { // log(N)
        while(true){
            String food = cuisineMap.get(cuisine).peek().food;
            int rating = cuisineMap.get(cuisine).peek().rating;
            if(foodMap.get(food) == rating){
                return food;
            }
            cuisineMap.get(cuisine).poll();
        }
    }
}