public class Twitter {
    
    private static class Tweet {
        public int id;
        public Tweet next;
        public long time;
        
        public Tweet(int id, Tweet head, long time) {
            this.id = id;
            this.next = head.next;
            head.next = this;
            this.time = time;
        }
        
        public Tweet() {}
    }
    
    private static class User {
        public int id;
        public Tweet head;
        
        public User(int id) {
            this.id = id;
            this.head = new Tweet();
        }
    }
    
    private static long time = 0;
    
    private Map<Integer, User> users;
    private Map<Integer, Set<Integer>> followship;

    /** Initialize your data structure here. */
    public Twitter() {
        this.users = new HashMap<Integer, User>();
        this.followship = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (this.users.containsKey(userId)) {
            User user = this.users.get(userId);
            Tweet tweet = new Tweet(tweetId, user.head, time);
            time++;
        } else {
            User user = new User(userId);
            this.users.put(userId, user);
            Tweet tweet = new Tweet(tweetId, user.head, time);
            time++;
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if (followship.containsKey(userId)) {
            Set<Integer> userIds = followship.get(userId);
            Queue<Integer> q = new PriorityQueue<Integer>(100, new Comparator<Tweet>() {
                @Override
                public int compare(Tweet a, Tweet b) {
                    if (a.time > b.time) {
                        return 1;
                    } else if (a.time < b.time) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            for (Integer uId : userIds) {
                if (this.users.containsKey(uId)) {
                    User user = this.users.get(uId);
                    if (user.head.next != null) {
                        q.offer(user.head.next);
                    }
                }
            }
            for (int i = 0;i < 10 && !q.isEmpty();i++) {
                Tweet tweet = q.poll();
                res.add(tweet.id);
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (this.followship.containsKey(followerId)) {
            this.followship.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<Integer>();
            set.add(followeeId);
            this.followship.put(followerId, set);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (this.followship.containsKey(followerId)) {
            Set<Integer> set = this.followship.get(followerId);
            set.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */