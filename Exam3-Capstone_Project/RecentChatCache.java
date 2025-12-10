public class RecentChatCache {

    private final IntelligentCache cache;

    public RecentChatCache(int capacity) {
        this.cache = new IntelligentCache(capacity);
    }

    // Open/update chat in cache
    public void openChat(int chatId, String title, String lastMessagePreview, long timestamp) {
        ChatEntry entry = new ChatEntry(chatId, title, lastMessagePreview, timestamp);
        cache.put(chatId, entry);
    }

    // If present return, null if not
    public ChatEntry lookupChat(int chatId) {
        Object value = cache.get(chatId);
        if (value instanceof ChatEntry) {
            return (ChatEntry) value;
        }
        return null;
    }

    public boolean isChatCached(int chatId) {
        return cache.containsKey(chatId);
    }

    public int currentChatCount() {
        return cache.size();
    }

    //Returns true if there are no cached chats.
    public boolean isEmpty() {
        return cache.isEmpty();
    }
}
