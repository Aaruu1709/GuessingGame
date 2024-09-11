package com.example.GuessingGame.GuessingGame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @GetMapping("/")
    public String home() {
        return "game"; // This maps to the game.html template
    }

    @GetMapping("/play")
    public String playGame(@RequestParam(value = "guess", required = false, defaultValue = "0") int guess, Model model) {
        int correctNumber = 7;
        String result;
        String hint = ""; // Hint message

        if (guess == correctNumber) {
            result = "Congratulations! You guessed the correct number.";
        } else {
            result = "Sorry, that's not the correct number. Try again!";
            if (guess < correctNumber) {
                hint = "Hint: The number is greater than " + guess + ".";
            } else {
                hint = "Hint: The number is less than " + guess + ".";
            }
        }

        model.addAttribute("result", result);
        model.addAttribute("hint", hint);

        return "game";
    }
}
