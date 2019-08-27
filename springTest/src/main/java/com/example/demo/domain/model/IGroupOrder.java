package com.example.demo.domain.model;

import javax.validation.GroupSequence;

@GroupSequence({IValidGroup1.class, IValidGroup2.class, IValidGroup3.class})
public interface IGroupOrder {

}
