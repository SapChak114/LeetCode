/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> flatList;
    List<NestedInteger> nl;
    int id;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flatList = new ArrayList<>();
        id = 0;
        nl = new ArrayList<>();
        flatten(nestedList);
    }

    @Override
    public Integer next() {
        return flatList.get(id++); 
    }

    @Override
    public boolean hasNext() {
        return id<flatList.size();
    }
    
    void flatten(List<NestedInteger> li){
        for(int i = 0; i<li.size(); i++){
            if(li.get(i).isInteger()){
                flatList.add(li.get(i).getInteger());
                continue;
            }
            flatten(li.get(i).getList());
        }
    }
}

   

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */