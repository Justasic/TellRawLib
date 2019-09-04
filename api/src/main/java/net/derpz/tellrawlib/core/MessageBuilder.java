package net.derpz.tellrawlib.core;

/**
 * A class to make constructing JSON messages simpler
 */
public interface MessageBuilder {
    /**
     * Starts a new Builder object with messageComponent as the first object
     * {@link MessageComponent}
     * @param messageComponent the message component that you would like to be first
     */
    void construct(MessageComponent messageComponent);

    /**
     * Starts a new Builder object with a String as the first object
     * The string is automatically converted into a MessageComponent and
     * will have its colour and formatting codes parsed automatically
     * @param message The message you would like to be included
     */
    void construct(String message);

    /**
     * Starts a new Builder object with another MessageBuilder as the object
     * The MessageBuilder is cloned into this MessageBuilder for modification
     */
    void construct(MessageBuilder messageBuilder);

    /**
     * Appends a message component onto the builder
     * @param messageComponent The message component you would like to append
     */
    void append(MessageComponent messageComponent);

    /**
     * Appends an array of message components onto
     * @param messageComponents A list of message components you would like to append
     */
    void append(MessageComponent[] messageComponents);

    /**
     * Append a list of string messages onto the message builder.
     * The message gets converted into a MessageComponent.
     * Formatting codes are automatically parsed
     * @param message The string message you would like to append
     */
    void append(String message);

    /**
     * Appends a list of string messages onto the message builder
     * Each of the messages get converted into a MessageComponent.
     * Formatting codes are automatically parsed
     * @param messages The list of string messages you would like to append
     */
    void append(String[] messages);

    /**
     * Appends a message builder onto the message builder.
     * Components within the message builder are appended
     * @param messageBuilder a message builder that you would like to append
     */
    void append(MessageBuilder messageBuilder);

    /**
     * Appends a list of message builders onto the message builder.
     * Components within each of the message builders are appended.
     * The builders are appended in order of the list.
     * @param messageBuilders A list of message builders that you would like to append
     */
    void append(MessageBuilder[] messageBuilders);
}
