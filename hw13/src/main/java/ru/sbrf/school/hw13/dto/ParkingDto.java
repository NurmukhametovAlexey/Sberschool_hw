package ru.sbrf.school.hw13.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkingDto {
    private List<Boolean> emptyParkLots;

    public OptionalInt park() {
        for (int i = 0; i < emptyParkLots.size(); i++) {
            if(emptyParkLots.get(i)) {
                emptyParkLots.set(i, false);
                return OptionalInt.of(i);
            }
        }
        return OptionalInt.empty();
    }

    public Boolean unpark(Integer lotId) {
        try {
            if (!emptyParkLots.get(lotId)) {
                emptyParkLots.set(lotId, true);
                return true;
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public Optional<List<Integer>> free() {
        List<Integer> freeLots = new ArrayList<>();
        for (int i = 0; i < emptyParkLots.size(); i++) {
            if (emptyParkLots.get(i)) {
                freeLots.add(i);
            }
        }
        if (freeLots.isEmpty())
            return Optional.empty();
        else
            return Optional.of(freeLots);
    }
}
