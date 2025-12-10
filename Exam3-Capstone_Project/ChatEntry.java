public class ChatEntry {
    private final int chatId;
    private final String title;
    private final String lastMessagePreview;
    private final long lastUpdatedTimestamp;

    public ChatEntry(int chatId, String title, String lastMessagePreview, long lastUpdatedTimestamp) {
        this.chatId = chatId;
        this.title = title;
        this.lastMessagePreview = lastMessagePreview;
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public int getChatId() {
        return chatId;
    }

    public String getTitle() {
        return title;
    }

    public String getLastMessagePreview() {
        return lastMessagePreview;
    }

    public long getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    @Override
    public String toString() {
        return "ChatEntry{" +
                "chatId=" + chatId +
                ", title='" + title + '\'' +
                ", lastMessagePreview='" + lastMessagePreview + '\'' +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                '}';
    }
}
