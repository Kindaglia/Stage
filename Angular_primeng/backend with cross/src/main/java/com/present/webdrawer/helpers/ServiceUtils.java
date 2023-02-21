package com.present.webdrawer.helpers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ServiceUtils<T, ID> {

    public T merge(T source, T target) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setSkipNullEnabled(true);
        modelMapper.map(source, target);
        return target;
    }
}
