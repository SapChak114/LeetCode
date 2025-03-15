/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> inMap = new HashMap<>();

        for (Employee e : employees) {
            inMap.put(e.id, e);
        }

        return rec(inMap, id);
    }

    int rec(Map<Integer, Employee> inpMap, int id) {
        int imp = inpMap.get(id).importance;

        for (int i : inpMap.get(id).subordinates) {
            imp += rec(inpMap, i);
        }

        return imp;
    }
}