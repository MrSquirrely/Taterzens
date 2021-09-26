package org.samo_lego.taterzens.mixin;

import net.minecraft.network.protocol.game.ServerboundCustomPayloadPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.samo_lego.taterzens.compatibility.Tmp;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Handles bungee packets.
 */
@Mixin(value = ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin_BungeeListener {
    @Inject(method = "handleCustomPayload", at = @At("TAIL"))
    private void onCustomPayload(ServerboundCustomPayloadPacket packet, CallbackInfo ci) {
        ResourceLocation packetId = packet.getIdentifier();
        /*if(AVAILABLE_SERVERS.isEmpty() && config.bungee.enableCommands) {
            if(packetId.equals(BungeeCompatibility.BUNGEE_CHANNEL)) {
                byte[] bytes = packet.getData().array();
                System.out.println(Arrays.toString(bytes) + " " + bytes.length);

                // Parsing the response
                if(bytes.length != 0) {
                    ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
                    String subchannel = in.readUTF();
                    System.out.println(subchannel);

                    if(subchannel.equals("GetServers")) {
                        // Adding available servers to suggestions
                        String[] servers = in.readUTF().split(", ");
                        Collections.addAll(AVAILABLE_SERVERS, servers);
                    }
                }
                else {
                    System.out.println("EMPTY");
                    System.out.println(packet.getData().readableBytes());
                    System.out.println(packet.getData().readerIndex());
                }
            } else if(packetId.equals(BRAND)) {
                // Fetch available servers from proxy
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("GetServers");
                BungeeCompatibility.sendProxyPacket((ServerGamePacketListenerImpl) (Object) this, out.toByteArray());
            }
        }*/
        Tmp.mixinRepace(packet, (ServerGamePacketListenerImpl) (Object) this);
    }
}
