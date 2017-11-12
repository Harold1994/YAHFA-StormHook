/*
 * Copyright 2014-2015 Marvin Wißfeld
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.larma.arthook;

import static de.larma.arthook.DebugHelper.hexdump;
import static de.larma.arthook.DebugHelper.addrHex;
import static de.larma.arthook.DebugHelper.logd;
import static de.larma.arthook.Native.memcpy;
import static de.larma.arthook.Native.memget;
import static de.larma.arthook.Native.memput;
import static de.larma.arthook.Native.mmap;
import static de.larma.arthook.Native.munmap;
import static de.larma.arthook.Native.munprotect;

public final class Memory {
    private static final String TAG = "Memory";

    private Memory() {
    }

    public static long map(int length) {
        long m = mmap(length);
        logd(TAG, "Mapped memory of size " + length + " at " + addrHex(m));
        return m;
    }

    public static boolean unmap(long address, int length) {
        logd(TAG, "Removing mapped memory of size " + length + " at " + addrHex(address));
        return munmap(address, length);
    }

    public static void put(byte[] bytes, long dest) {
        logd(TAG, "Writing memory to: " + addrHex(dest));
        logd(TAG, hexdump(bytes, dest));
        memput(bytes, dest);
    }

    public static byte[] get(long src, int length) {
        logd(TAG, "Reading " + length + " bytes from: " + addrHex(src));
        byte[] bytes = memget(src, length);
        logd(TAG, hexdump(bytes, src));
        return bytes;
    }

    public static boolean unprotect(long addr, long len) {
        logd(TAG, "Disabling mprotect from " + addrHex(addr));
        return munprotect(addr, len);
    }

    public static void copy(long src, long dst, int length) {
        logd(TAG, "Copy " + length + " bytes form " + addrHex(src) + " to " + addrHex(dst));
        memcpy(src, dst, length);
    }
}
