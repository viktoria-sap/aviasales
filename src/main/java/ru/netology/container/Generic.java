package ru.netology.container;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Generic<T> {
    private T value;
    // constructor + isEmpty + getValue
}