package com.lzl.SnowFlakeId;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;

public class Main {
    public static void main(String[] args) {
        IdGeneratorOptions options = new IdGeneratorOptions();
        options.WorkerIdBitLength = 10;
        options.SeqBitLength = 6;
        YitIdHelper.setIdGenerator(options);
        long id = YitIdHelper.nextId();
        System.out.println(id);

    }


}
