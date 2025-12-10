public class Main {

    public static void main(String[] args) {
        testBasicInsertAndLookup();
        testEvictionOrder();
        testRecencyUpdateOnLookup();
    }

    private static void testBasicInsertAndLookup() {
        System.out.println("[Test 1] insert and lookup");

        RecentChatCache chatCache = new RecentChatCache(3);
        chatCache.openChat(1, "Chat 1", "Hello", System.currentTimeMillis());
        chatCache.openChat(2, "Chat 2", "Hi there", System.currentTimeMillis());

        ChatEntry result = chatCache.lookupChat(1);

        if (result != null && result.getChatId() == 1 && "Chat 1".equals(result.getTitle())) {
            System.out.println("PASS: Found chat 1 correctly.");
        } else {
            System.out.println("FAIL: Did not find chat 1 correctly.");
        }
    }

    private static void testEvictionOrder() {
        System.out.println("[Test 2] Eviction (least recently used)");

        RecentChatCache chatCache = new RecentChatCache(3);

        // Fill cache: 1, 2, 3
        chatCache.openChat(1, "Chat 1", "First", System.currentTimeMillis());
        chatCache.openChat(2, "Chat 2", "Second", System.currentTimeMillis());
        chatCache.openChat(3, "Chat 3", "Third", System.currentTimeMillis());

        chatCache.lookupChat(1);

        chatCache.openChat(4, "Chat 4", "Fourth", System.currentTimeMillis());

        ChatEntry chat2 = chatCache.lookupChat(2);
        ChatEntry chat3 = chatCache.lookupChat(3);
        ChatEntry chat4 = chatCache.lookupChat(4);

        if (chat2 == null && chat3 != null && chat4 != null) {
            System.out.println("PASS: Chat 2 was evicted, 3 and 4 are still in cache.");
        } else {
            System.out.println("FAIL: Eviction order is incorrect.");
        }
    }

    private static void testRecencyUpdateOnLookup() {
        System.out.println("[Test 3] Recency update on lookup");

        RecentChatCache chatCache = new RecentChatCache(2);

        chatCache.openChat(1, "Chat 1", "First", System.currentTimeMillis());
        chatCache.openChat(2, "Chat 2", "Second", System.currentTimeMillis());

        chatCache.lookupChat(1);

        chatCache.openChat(3, "Chat 3", "Third", System.currentTimeMillis());

        ChatEntry chat1 = chatCache.lookupChat(1);
        ChatEntry chat2 = chatCache.lookupChat(2);
        ChatEntry chat3 = chatCache.lookupChat(3);

        if (chat1 != null && chat2 == null && chat3 != null) {
            System.out.println("PASS: Lookup updated recency correctly (2 evicted, 1 & 3 kept).");
        } else {
            System.out.println("FAIL: Recency after lookup is incorrect.");
        }
    }
}
