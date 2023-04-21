package it.aulab.learningplatform.util.mapping;

import java.util.Collection;

import org.modelmapper.AbstractConverter;

public class ConvertCollectionToInteger extends AbstractConverter<Collection<?>, Integer> {
    @Override
    protected Integer convert(Collection<?> source) { return source.size(); } 
}
