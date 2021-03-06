package org.jetlinks.community.device.message;

import org.jetlinks.core.message.DeviceMessage;
import org.jetlinks.core.message.MessageType;
import org.jetlinks.community.gateway.EncodableMessage;
import org.jetlinks.community.gateway.TopicMessage;

import java.util.Map;
import java.util.Optional;

public class DeviceMessageUtils {

    public static Optional<DeviceMessage> convert(TopicMessage message){
        if (message.getMessage() instanceof EncodableMessage) {
            Object nativeMessage = ((EncodableMessage) message.getMessage()).getNativePayload();
            if (nativeMessage instanceof DeviceMessage) {
                return Optional.of((DeviceMessage)nativeMessage);
            } else if (nativeMessage instanceof Map) {
                return MessageType.convertMessage(((Map<String, Object>) nativeMessage));
            }
        }
        return Optional.empty();
    }

}
