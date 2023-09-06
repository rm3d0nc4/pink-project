package com.example.pink_project.contracts;

import com.example.pink_project.exceptions.AppException;

public interface Usecase<In, Out> {
    Out execute(In data) throws AppException;

}



