class Solution {
public:
    int trap(vector<int>& v) {
          int left=0;
   int right=v.size()-1;
   int water=0;
   int maxleft=0;int maxright=0;
   while(left<=right){
       if(v[left]<=v[right]){
           if(v[left]>maxleft) maxleft=v[left];
           else {
               water+=maxleft-v[left];left++;
           }
       }
       else{
           if(v[right]>maxright) maxright=v[right];
           else{
               water+=maxright-v[right];right--;
           }
       }
   }

   return water; 
    }
};