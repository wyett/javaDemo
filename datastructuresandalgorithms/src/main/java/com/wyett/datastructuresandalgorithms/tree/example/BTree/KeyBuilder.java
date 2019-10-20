package com.wyett.datastructuresandalgorithms.tree.example.BTree;

import java.io.*;
import java.util.Stack;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/22 16:49
 * @description: create keys, save the max key when the program
 * stop, and reload it when program restart
 */

public class KeyBuilder {
    // key count per batch
    private int batchCount;
    private Stack<Integer> keyStack;
    private int maxKeyValue;
    private static final String keyFile = System.getProperty("user.dir")
            + File.separator + "bTreeKey.binary";

    public KeyBuilder(int batchCount) {
        this.batchCount = batchCount;
        this.keyStack = new Stack<>();
        reloadMaxKey();
    }

    public void setMaxKey() {
        this.maxKeyValue = maxKeyValue + batchCount;
    }

    private void saveMaxKey() {
        BufferedOutputStream fw = null;
        try {
            File keyCache = new File(keyFile);
            if (!keyCache.exists()) {
                keyCache.createNewFile();
            }
            fw = new BufferedOutputStream(new FileOutputStream(keyFile));
            fw.write(maxKeyValue);
            fw.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void reloadMaxKey() {
        BufferedInputStream bis = null;
        try {
            File keyCache = new File(keyFile);
            if (keyCache.exists()) {
                bis = new BufferedInputStream(new FileInputStream(keyFile));
                this.maxKeyValue = (int) bis.read();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public Stack<Integer> putKeysIntoStack() {
        for (int i = 0; i <= batchCount; i++) {
            keyStack.push(maxKeyValue + i);
        }
        setMaxKey();
        return keyStack;
    }

}
