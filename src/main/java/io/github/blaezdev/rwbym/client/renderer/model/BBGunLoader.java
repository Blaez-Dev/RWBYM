package io.github.blaezdev.rwbym.client.renderer.model;

import javax.annotation.Nonnull;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.client.renderer.model.bbgunmodel.UnbakedBBGunModel;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class BBGunLoader implements ICustomModelLoader {

    @Override
    public void onResourceManagerReload(@Nonnull IResourceManager resourceManager) {

    }

    /**
     * Checks if given model should be loaded by this loader.
     * Reading file contents is inadvisable, if possible decision should be made based on the location alone.
     *
     * @param modelLocation The path, either to an actual file or a {@link ModelResourceLocation}.
     */
    @Override
    public boolean accepts(ResourceLocation modelLocation) {
        return modelLocation.getResourceDomain().equals(RWBYModels.MODID) && modelLocation.getResourcePath().endsWith(".bbmodel");
    }

    /**
     * @param modelLocation The model to (re)load, either path to an
     *                      actual file or a {@link ModelResourceLocation}.
     */
    @Nonnull
    @Override
    public IModel loadModel(@Nonnull ResourceLocation modelLocation) throws Exception {
        RWBYModels.LOGGER.info("Loading Model: {}", modelLocation);
        try {
        	return new UnbakedBBGunModel(modelLocation);
        }
        catch (Exception e) {
        	e.printStackTrace();
        	throw e;
        }
    }
}
