package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepositories;
import guru.springframework.repositories.UnitOfMeasureRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepositories categoryRepositories;
    private UnitOfMeasureRepositories unitOfMeasureRepositories;

    public IndexController(CategoryRepositories categoryRepositories, UnitOfMeasureRepositories unitOfMeasureRepositories) {
        this.categoryRepositories = categoryRepositories;
        this.unitOfMeasureRepositories = unitOfMeasureRepositories;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepositories.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Teaspoon");

        System.out.println("Cat Id is:" + categoryOptional.get().getId());
        System.out.println("UOM ID is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
