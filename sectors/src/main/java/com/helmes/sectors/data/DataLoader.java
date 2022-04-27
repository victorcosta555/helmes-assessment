package com.helmes.sectors.data;

import com.helmes.sectors.models.Sector;
import com.helmes.sectors.repositories.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final SectorRepository sectorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Sector> sectorList = new ArrayList<>();
        sectorList.add(Sector.builder().id(1L).name("Manufacturing").build());
        sectorList.add(Sector.builder().id(19L).name("Construction materials").build());
        sectorList.add(Sector.builder().id(18L).name("Electronics and Optics").build());
        sectorList.add(Sector.builder().id(6L).name("Food and Beverage").build());
        sectorList.add(Sector.builder().id(342L).name("Bakery & confectionery products").build());
        sectorList.add(Sector.builder().id(43L).name("Beverages").build());
        sectorList.add(Sector.builder().id(42L).name("Fish & fish products").build());
        sectorList.add(Sector.builder().id(40L).name("Meat & meat products").build());
        sectorList.add(Sector.builder().id(39L).name("Milk & dairy products").build());
        sectorList.add(Sector.builder().id(437L).name("Sweets & snack food").build());
        sectorList.add(Sector.builder().id(13L).name("Furniture").build());
        sectorList.add(Sector.builder().id(389L).name("Bathroom/sauna").build());
        sectorList.add(Sector.builder().id(385L).name("Bedroom").build());
        sectorList.add(Sector.builder().id(390L).name("Children’s room").build());
        sectorList.add(Sector.builder().id(98L).name("Kitchen").build());
        sectorList.add(Sector.builder().id(101L).name("Living room").build());
        sectorList.add(Sector.builder().id(392L).name("Office").build());
        sectorList.add(Sector.builder().id(394L).name("Other (Furniture)").build());
        sectorList.add(Sector.builder().id(341L).name("Outdoor").build());
        sectorList.add(Sector.builder().id(99L).name("Project furniture").build());
        sectorList.add(Sector.builder().id(12L).name("Machinery").build());
        sectorList.add(Sector.builder().id(94L).name("Machinery components").build());
        sectorList.add(Sector.builder().id(91L).name("Machinery equipment/tools").build());
        sectorList.add(Sector.builder().id(224L).name("Manufacture of machinery").build());
        sectorList.add(Sector.builder().id(97L).name("Maritime").build());
        sectorList.add(Sector.builder().id(271L).name("Aluminium and steel workboats").build());
        sectorList.add(Sector.builder().id(269L).name("Boat/Yacht building").build());
        sectorList.add(Sector.builder().id(230L).name("Ship repair and conversion").build());
        sectorList.add(Sector.builder().id(230L).name("Metal structures").build());
        sectorList.add(Sector.builder().id(508L).name("Other").build());
        sectorList.add(Sector.builder().id(227L).name("Repair and maintenance service").build());
        sectorList.add(Sector.builder().id(11L).name("Metalworking").build());
        sectorList.add(Sector.builder().id(67L).name("Construction of metal structures").build());
        sectorList.add(Sector.builder().id(263L).name("Houses and buildings").build());
        sectorList.add(Sector.builder().id(267L).name("Metal products").build());
        sectorList.add(Sector.builder().id(542L).name("Metal works").build());
        sectorList.add(Sector.builder().id(75L).name("CNC-machining").build());
        sectorList.add(Sector.builder().id(62L).name("Forgings, Fasteners").build());
        sectorList.add(Sector.builder().id(69L).name("Gas, Plasma, Laser cutting").build());
        sectorList.add(Sector.builder().id(66L).name("MIG, TIG, Aluminum welding").build());
        sectorList.add(Sector.builder().id(9L).name("Plastic and Rubber").build());
        sectorList.add(Sector.builder().id(556L).name("Plastic goods").build());
        sectorList.add(Sector.builder().id(559L).name("Plastic processing technology").build());
        sectorList.add(Sector.builder().id(55L).name("Blowing").build());
        sectorList.add(Sector.builder().id(57L).name("Moulding").build());
        sectorList.add(Sector.builder().id(53L).name("Plastics welding and processing").build());
        sectorList.add(Sector.builder().id(560L).name("Plastic profiles").build());
        sectorList.add(Sector.builder().id(5L).name("Printing").build());
        sectorList.add(Sector.builder().id(150L).name("Book/Periodicals printing").build());
        sectorList.add(Sector.builder().id(145L).name("Labelling and packaging printing").build());
        sectorList.add(Sector.builder().id(7L).name("Textile and Clothing").build());
        sectorList.add(Sector.builder().id(44L).name("Clothing").build());
        sectorList.add(Sector.builder().id(8L).name("Wood").build());
        sectorList.add(Sector.builder().id(337L).name("Other (Wood)").build());
        sectorList.add(Sector.builder().id(51L).name("Wooden building materials").build());
        sectorList.add(Sector.builder().id(47L).name("Wooden houses").build());
        sectorList.add(Sector.builder().id(3L).name("Other").build());
        sectorList.add(Sector.builder().id(37L).name("Creative industries").build());
        sectorList.add(Sector.builder().id(29L).name("Energy technology").build());
        sectorList.add(Sector.builder().id(33L).name("Environment").build());
        sectorList.add(Sector.builder().id(2L).name("Service").build());
        sectorList.add(Sector.builder().id(25L).name("Business services").build());
        sectorList.add(Sector.builder().id(35L).name("Engineering").build());
        sectorList.add(Sector.builder().id(28L).name("Information Technology and Telecommunications").build());
        sectorList.add(Sector.builder().id(581L).name("Data processing, Web portals, E-marketing").build());
        sectorList.add(Sector.builder().id(576L).name("Programming, Consultancy").build());
        sectorList.add(Sector.builder().id(121L).name("Software, Hardware").build());
        sectorList.add(Sector.builder().id(122L).name("Telecommunications").build());
        sectorList.add(Sector.builder().id(141L).name("Translation services").build());
        sectorList.add(Sector.builder().id(21L).name("Transport and Logistics").build());
        sectorList.add(Sector.builder().id(111L).name("Air").build());
        sectorList.add(Sector.builder().id(114L).name("Rail").build());
        sectorList.add(Sector.builder().id(112L).name("Road").build());
        sectorList.add(Sector.builder().id(113L).name("Water").build());
        sectorRepository.saveAll(sectorList);
    }
}
