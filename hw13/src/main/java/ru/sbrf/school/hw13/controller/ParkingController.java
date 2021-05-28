package ru.sbrf.school.hw13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.school.hw13.dto.ParkingDto;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ParkingController {
    private Integer parkPlaceSize = 20;

    private ParkingDto parkPlace = new ParkingDto(
            Stream.generate(()->true)
                    .limit(parkPlaceSize)
                    .collect(Collectors.toList())
    );

    @PostMapping("/park")
    public String park() {
        OptionalInt result = parkPlace.park();
        if (result.isPresent()) {
            return "Parked your car! Lot ID: " + result.getAsInt();
        } else {
            return "Unable to find a spot for your car!";
        }
    }

    @PostMapping("/unpark")
    public String unpark(@RequestParam(value = "lotID", required = true) Integer lotID) {
        if (parkPlace.unpark(lotID)) {
            return "Car successfully unparked! Lot " + lotID + " is empty now!";
        } else {
            return "Something went wrong. Maybe the \"lotID\" is wrong.";
        }
    }

    @GetMapping("/free")
    public String free() {
        Optional<List<Integer>> freeLots = parkPlace.free();
        if (freeLots.isEmpty()) {
            return "No free parking lots left!";
        } else {
            return "Printing available park lots:\n" + freeLots.get().toString();
        }
    }

}
