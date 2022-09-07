/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.buffer;

/**
 * Netty 中的内存分配是基于 ByteBufAllocator 这个接口实现的，通过对它的具体实现，可以用来分配我们之前描述过的任意类型的 BytebBuf 实例
 * Implementations are responsible to allocate buffers. Implementations of this interface are expected to be
 * thread-safe.
 *
 * @see {@link PooledByteBufAllocator}   池化
 * @see {@link UnpooledByteBufAllocator}  非池化
 */
public interface ByteBufAllocator {

    ByteBufAllocator DEFAULT = ByteBufUtil.DEFAULT_ALLOCATOR;

    /**
     * 根据具体实现返回基于直接内存或堆内内存的ByteBuf
     * Allocate a {@link ByteBuf}. If it is a direct or heap buffer
     * depends on the actual implementation.
     */
    ByteBuf buffer();

    /**
     * 根据具体实现返回一个给定初始容量的基于直接内存或堆内内存的ByteBuf
     * Allocate a {@link ByteBuf} with the given initial capacity.
     * If it is a direct or heap buffer depends on the actual implementation.
     */
    ByteBuf buffer(int initialCapacity);

    /**
     * 根据具体实现返回一个给定初始容量与最大量的基于直接内存或堆内内存的ByteBuf
     * Allocate a {@link ByteBuf} with the given initial capacity and the given
     * maximal capacity. If it is a direct or heap buffer depends on the actual
     * implementation.
     */
    ByteBuf buffer(int initialCapacity, int maxCapacity);

    /**
     * 返回一个用于套接字操作的ByteBuf
     * Allocate a {@link ByteBuf}, preferably a direct buffer which is suitable for I/O.
     */
    ByteBuf ioBuffer();

    /**
     * 返回一个用于套接字操作的给定初始量ByteBuf
     * Allocate a {@link ByteBuf}, preferably a direct buffer which is suitable for I/O.
     */
    ByteBuf ioBuffer(int initialCapacity);

    /**
     * 返回一个用于套接字操作的给定初始量与最大量的ByteBuf
     * Allocate a {@link ByteBuf}, preferably a direct buffer which is suitable for I/O.
     */
    ByteBuf ioBuffer(int initialCapacity, int maxCapacity);

    /**
     * 返回一个基于堆内内存的ByteBuf
     * Allocate a heap {@link ByteBuf}.
     */
    ByteBuf heapBuffer();

    /**
     * 返回一个给定初始量基于堆内内存的ByteBuf
     * Allocate a heap {@link ByteBuf} with the given initial capacity.
     */
    ByteBuf heapBuffer(int initialCapacity);

    /**
     * 返回一个给定初始量与最大量的基于堆内内存的ByteBuf
     * Allocate a heap {@link ByteBuf} with the given initial capacity and the given
     * maximal capacity.
     */
    ByteBuf heapBuffer(int initialCapacity, int maxCapacity);

    /**
     * 返回一个基于直接内存的ByteBuf
     * Allocate a direct {@link ByteBuf}.
     */
    ByteBuf directBuffer();

    /**
     * 返回一个给定初始量基于直接内存的ByteBuf
     * Allocate a direct {@link ByteBuf} with the given initial capacity.
     */
    ByteBuf directBuffer(int initialCapacity);

    /**
     * 返回一个给定初始量与最大量的基于直接内存的ByteBuf
     * Allocate a direct {@link ByteBuf} with the given initial capacity and the given
     * maximal capacity.
     */
    ByteBuf directBuffer(int initialCapacity, int maxCapacity);

    /**
     * 返回一个基于复合缓冲区的ByteBuf，基于堆还是直接内存看具体实现
     * Allocate a {@link CompositeByteBuf}.
     * If it is a direct or heap buffer depends on the actual implementation.
     */
    CompositeByteBuf compositeBuffer();

    /**
     * 返回一个给定最大量的基于复合缓冲区的ByteBuf，基于堆还是直接内存看具体实现
     * Allocate a {@link CompositeByteBuf} with the given maximum number of components that can be stored in it.
     * If it is a direct or heap buffer depends on the actual implementation.
     */
    CompositeByteBuf compositeBuffer(int maxNumComponents);

    /**
     * 返回一个基于堆内存的CompositeByteBuf
     * Allocate a heap {@link CompositeByteBuf}.
     */
    CompositeByteBuf compositeHeapBuffer();

    /**
     * 返回一个给定最大量基于堆内存的CompositeByteBuf
     * Allocate a heap {@link CompositeByteBuf} with the given maximum number of components that can be stored in it.
     */
    CompositeByteBuf compositeHeapBuffer(int maxNumComponents);

    /**
     * 返回一个基于直接内存的CompositeByteBuf
     * Allocate a direct {@link CompositeByteBuf}.
     */
    CompositeByteBuf compositeDirectBuffer();

    /**
     * 返回一个给定最大量的基于直接内存的CompositeByteBuf
     * Allocate a direct {@link CompositeByteBuf} with the given maximum number of components that can be stored in it.
     */
    CompositeByteBuf compositeDirectBuffer(int maxNumComponents);

    /**
     * 直接内存是否池化管理
     * Returns {@code true} if direct {@link ByteBuf}'s are pooled
     */
    boolean isDirectBufferPooled();

    /**
     * 计算bytebuf需要扩展时的新容量
     * Calculate the new capacity of a {@link ByteBuf} that is used when a {@link ByteBuf} needs to expand by the
     * {@code minNewCapacity} with {@code maxCapacity} as upper-bound.
     */
    int calculateNewCapacity(int minNewCapacity, int maxCapacity);
 }
