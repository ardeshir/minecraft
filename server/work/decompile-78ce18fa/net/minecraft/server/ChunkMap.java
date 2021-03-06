package net.minecraft.server;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkMap extends Long2ObjectOpenHashMap<Chunk> {

    private static final Logger a = LogManager.getLogger();

    public ChunkMap(int i) {
        super(i);
    }

    public Chunk a(long i, Chunk chunk) {
        Chunk chunk1 = (Chunk) super.put(i, chunk);
        ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(i);

        for (int j = chunkcoordintpair.x - 1; j <= chunkcoordintpair.x + 1; ++j) {
            for (int k = chunkcoordintpair.z - 1; k <= chunkcoordintpair.z + 1; ++k) {
                if (j != chunkcoordintpair.x || k != chunkcoordintpair.z) {
                    long l = ChunkCoordIntPair.a(j, k);
                    Chunk chunk2 = (Chunk) this.get(l);

                    if (chunk2 != null) {
                        chunk.H();
                        chunk2.H();
                    }
                }
            }
        }

        return chunk1;
    }

    public Chunk a(Long olong, Chunk chunk) {
        return this.a(olong.longValue(), chunk);
    }

    public Chunk a(long i) {
        Chunk chunk = (Chunk) super.remove(i);
        ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(i);

        for (int j = chunkcoordintpair.x - 1; j <= chunkcoordintpair.x + 1; ++j) {
            for (int k = chunkcoordintpair.z - 1; k <= chunkcoordintpair.z + 1; ++k) {
                if (j != chunkcoordintpair.x || k != chunkcoordintpair.z) {
                    Chunk chunk1 = (Chunk) this.get(ChunkCoordIntPair.a(j, k));

                    if (chunk1 != null) {
                        chunk1.I();
                    }
                }
            }
        }

        return chunk;
    }

    public Chunk a(Object object) {
        return this.a(((Long) object).longValue());
    }

    public void putAll(Map<? extends Long, ? extends Chunk> map) {
        throw new RuntimeException("Not yet implemented");
    }

    public boolean remove(Object object, Object object1) {
        throw new RuntimeException("Not yet implemented");
    }

    public Object remove(long i) {
        return this.a(i);
    }

    public Object put(long i, Object object) {
        return this.a(i, (Chunk) object);
    }

    public Object remove(Object object) {
        return this.a(object);
    }

    public Object put(Long olong, Object object) {
        return this.a(olong, (Chunk) object);
    }

    public Object put(Object object, Object object1) {
        return this.a((Long) object, (Chunk) object1);
    }
}
