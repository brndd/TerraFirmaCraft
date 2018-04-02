package net.dries007.tfc.world.classic;

import net.dries007.tfc.objects.biomes.BiomesTFC;
import net.dries007.tfc.world.classic.genlayers.GenLayerTFC;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;

import java.util.Collections;
import java.util.List;

public class BiomeProviderTFC extends BiomeProvider
{
    public BiomeProviderTFC(World world)
    {
        super(world.getWorldInfo());

        if (!(world.getWorldType() instanceof WorldTypeTFC))
            throw new RuntimeException("Terrible things have gone wrong here.");

        List<Biome> biomesToSpawnIn = getBiomesToSpawnIn();
        biomesToSpawnIn.clear();
        Collections.addAll(biomesToSpawnIn, BiomesTFC.getPlayerSpawnBiomes());
    }

    @Override
    public float getTemperatureAtHeight(float p_76939_1_, int p_76939_2_)
    {
        return super.getTemperatureAtHeight(p_76939_1_, p_76939_2_);
    }

    /**
     * This is where we do the actual override of the generation, we discard the original and insert our own.
     */
    @Override
    public GenLayer[] getModdedBiomeGenerators(WorldType worldType, long seed, GenLayer[] original)
    {
        original = GenLayerTFC.initialize2(seed);
        return super.getModdedBiomeGenerators(worldType, seed, original);
    }
}
