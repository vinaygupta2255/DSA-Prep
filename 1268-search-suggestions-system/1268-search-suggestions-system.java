class Solution {

    //Solution-1 using Binary Search
    // T.C = O(nlog(n))+O(mlog(n)) , S.C = O(1) to O(n)
    public List<List<String>> suggestedProducts1(String[] products, String searchWord) {
        Arrays.sort(products);
        int start = 0;
        int bStart = 0;
        int length = products.length;
        List<List<String>> ans = new ArrayList<>();
        String prefix = new String("");

        for (char c : searchWord.toCharArray()) {
            prefix += c;

            //find startIndex of this prifix using BinarySearch
            start = lower_bound(products, start, prefix);

            ans.add(new ArrayList());
            for (int i = start; i < Math.min(products.length, start + 3); i++) {
                if (products[i].length() < prefix.length() 
                    || !products[i].substring(0, prefix.length()).equals(prefix)) {
                    break;
                }
                ans.get(ans.size() - 1).add(products[i]);
            }
            bStart = Math.abs(start);
        }
        return ans;
    }

    int lower_bound(String[] products, int start, String word) {
        int i = start, j = products.length, mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (products[mid].compareTo(word) >= 0) j = mid; else i = mid + 1;
        }
        return i;
    }

    // Solution-2 using 2 pointers approach
    //T.C = O(nlogn + n + m) , S.C = O(n)
    // https://www.youtube.com/watch?v=D4T2N0yAr20&ab_channel=NeetCode
    // after array is sorted, if we see a prefix is matched at ith index from start and          jth index  from end. then its definatley sure that inbetween words will be matched        also, because the array is sorted. Hence we will pick n words from that inbetween        range of array.
    // Also if for prefix 2 first words are not matched, then it is definatly sure these        will never be matched after adding few characters in prefix going forward, so we          will just ignore these from further iterations.

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int l = 0, r = products.length - 1;
        List<List<String>> res = new LinkedList<>();
        
        for(int i = 0; i < searchWord.length();i++) {
            char c = searchWord.charAt(i);
            while(l <= r && (products[l].length() <=i || products[l].charAt(i) != c))
                l++;
            while(l <= r && (products[r].length() <= i || products[r].charAt(i) != c))
                r--;
        
            List<String> rs = new LinkedList<>();
            int remains = r - l + 1;
            for(int j = 0; j < Math.min(3,remains);j++)
                rs.add(products[l+j]);
            res.add(rs);
        }
            return res;
    }
    
    //Solution-3 using Trie and DFS
    // Tough one, can check in Solutions section
    
    
}
