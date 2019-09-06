package net.derpz.tellrawlib.core;

import net.derpz.tellrawlib.core.components.MessageComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class to make constructing JSON messages simpler
 */
public class MessageBuilder {

    private List<MessageComponent> components = new ArrayList<>();

    /**
     * Starts a new Builder object with messageComponent as the first object
     * {@link MessageComponent}
     *
     * @param messageComponent the message component that you would like to be first
     */
    public MessageBuilder(MessageComponent messageComponent) {
        components.add(messageComponent);
    }

    /**
     * Starts a new Builder object with a String as the first object
     * The string is automatically converted into a MessageComponent and
     * will have its colour and formatting codes parsed automatically
     *
     * @param message The message you would like to be included
     */
    public MessageBuilder(String message) {
        components.add(new MessageComponent(message));
    }

    /**
     * Starts a new Builder object with another MessageBuilder as the object
     * The MessageBuilder is cloned into this MessageBuilder for modification
     */
    public MessageBuilder(MessageBuilder messageBuilder) {
        this.components = messageBuilder.getComponents();
    }

    /**
     * Appends a message component onto the builder
     * @param messageComponent The message component you would like to append
     * @return this MessageBuilder for chaining
     */
    public MessageBuilder append(MessageComponent messageComponent) {
        this.components.add(messageComponent);
        return this;
    }

    /**
     * Appends an array of message components onto
     *
     * @param messageComponents A list of message components you would like to append
     * @return this MessageBuilder for chaining
     */
    public MessageBuilder append(MessageComponent[] messageComponents) {
        this.components.addAll(Arrays.asList(messageComponents));
        return this;
    }

    /**
     * Append a list of string messages onto the message builder.
     * The message gets converted into a MessageComponent.
     * Formatting codes are automatically parsed
     *
     * @param message The string message you would like to append
     * @return this MessageBuilder for chaining
     */
    public MessageBuilder append(String message) {
        this.components.add(new MessageComponent(message));
        return this;
    }

    /**
     * Appends a list of string messages onto the message builder
     * Each of the messages get converted into a MessageComponent.
     * Formatting codes are automatically parsed
     *
     * @param messages The list of string messages you would like to append
     * @return this MessageBuilder for chaining
     */
    public MessageBuilder append(String[] messages) {
        for (String msg : messages) {
            this.components.add(new MessageComponent(msg));
        }
        return this;
    }

    /**
     * Appends a message builder onto the message builder.
     * Components within the message builder are appended
     *
     * @param messageBuilder a message builder that you would like to append
     * @return this MessageBuilder for chaining
     */
    public MessageBuilder append(MessageBuilder messageBuilder) {
        this.components.addAll(messageBuilder.getComponents());
        return this;
    }

    /**
     * Appends a list of message builders onto the message builder.
     * Components within each of the message builders are appended.
     * The builders are appended in order of the list.
     *
     * @param messageBuilders A list of message builders that you would like to append
     * @return this MessageBuilder for chaining
     */
    public MessageBuilder append(MessageBuilder[] messageBuilders) {
        for (MessageBuilder builder: messageBuilders) {
            this.components.addAll(builder.getComponents());
        }
        return this;
    }

    public List<MessageComponent> getComponents() {
        return this.components;
    }
}
