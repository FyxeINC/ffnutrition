package com.fyxeinc.ffnutrition;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.attachment.AttachmentSyncHandler;
import net.neoforged.neoforge.attachment.IAttachmentHolder;

import javax.annotation.Nullable;

public class NutritionDataSyncHandler implements AttachmentSyncHandler<NutritionData>
{
    @Override
    public void write(RegistryFriendlyByteBuf buf, NutritionData attachment, boolean initialSync)
    {
        // Write the attachment data to the buffer
        // If `initialSync` is true, you should write the entire attachment as the client does not have any prior data
        // If `initialSync` is false, you can choose to only write the data you would like to update

        // Example:
        if (initialSync)
        {
            // Write entire attachment
            NutritionData.STREAM_CODEC.encode(buf, attachment);
        }
        else
        {
            // Write update data
        }
    }

    @Override
    @Nullable
    public NutritionData read(IAttachmentHolder holder, RegistryFriendlyByteBuf buf, @Nullable NutritionData previousValue)
    {
        // Read the data from the buffer and return the new data attachment
        // `previousValue` is `null` if there was no prior data on the client
        // The result should return `null` if the data attachment should be removed

        // Example:
        if (previousValue == null)
        {
            // Read entire attachment
            return NutritionData.STREAM_CODEC.decode(buf);
        }
        else
        {
            // Read update data and merge to previous value
            NutritionData newData = NutritionData.STREAM_CODEC.decode(buf);
            previousValue.setNutritionValueCollection(newData.getNutritionValueCollection());
            return previousValue;
        }
    }

    @Override
    public boolean sendToPlayer(IAttachmentHolder holder, ServerPlayer to)
    {
        // Return whether the holder data is synced to the given player client
        // The players checked are different depending on the attachment holder:
        // - Block entities: All players tracking the chunk the block entity is within
        // - Chunk: All players tracking the chunk
        // - Entity: All players tracking the current entity, includes the current player if they are the attachment holder
        // - Level: All players in the current dimension / level

        // Example:
        // Only send the attachment if they are the attachment holder
        return holder == to;
        // TODO - make this send to all players
    }
}
