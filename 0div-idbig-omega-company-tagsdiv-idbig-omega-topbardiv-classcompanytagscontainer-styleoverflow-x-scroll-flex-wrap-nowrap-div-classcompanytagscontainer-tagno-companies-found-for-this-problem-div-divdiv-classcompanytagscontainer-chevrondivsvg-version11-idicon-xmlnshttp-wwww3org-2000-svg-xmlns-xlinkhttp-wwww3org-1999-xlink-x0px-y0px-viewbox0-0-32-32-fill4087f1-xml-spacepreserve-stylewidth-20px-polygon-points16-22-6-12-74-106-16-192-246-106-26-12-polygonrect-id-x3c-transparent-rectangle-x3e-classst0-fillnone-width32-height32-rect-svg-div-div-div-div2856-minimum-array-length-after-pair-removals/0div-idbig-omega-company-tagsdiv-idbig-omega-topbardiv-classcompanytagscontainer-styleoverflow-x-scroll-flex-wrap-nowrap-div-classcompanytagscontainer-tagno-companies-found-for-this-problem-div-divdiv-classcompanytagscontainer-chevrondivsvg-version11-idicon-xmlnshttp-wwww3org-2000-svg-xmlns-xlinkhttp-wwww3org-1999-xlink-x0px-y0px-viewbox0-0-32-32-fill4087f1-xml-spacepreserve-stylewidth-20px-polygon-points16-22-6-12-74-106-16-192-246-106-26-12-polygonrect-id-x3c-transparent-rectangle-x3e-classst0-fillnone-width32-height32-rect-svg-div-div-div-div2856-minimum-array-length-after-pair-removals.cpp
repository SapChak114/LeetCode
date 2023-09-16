class Solution {
public:
    int minLengthAfterRemovals(vector<int>& nums) {
        map<int,int>mp;
        for(auto it:nums)mp[it]++;
        priority_queue<int>pq;
        for(auto it:mp)pq.push(it.second);
        
        while(pq.size()>=2)
        {
            int top1=pq.top();
            pq.pop();
            int top2=pq.top();
            pq.pop();
            //cout<<top1<<" top 1 "<<top2<<" top2\n";
            top1--;
            top2--;
            if(top1)pq.push(top1);
            if(top2)pq.push(top2);
            //cout<<pq.size()<<" size\n";
        }
       
       return pq.size()?pq.top():0;
        
        
        
    }
};