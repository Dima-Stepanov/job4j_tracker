package ru.job4j.stream.builder;

/**
 * 1.4.2. Stream API.
 * 9. Шаблоны проектирования в Stream API [#310012].
 * Модель данных описывает характеристики планеты солнечной системы.
 *
 * @author Dima_Nout
 * @version 1
 * @since 10.10.2021
 */
public class Planet {
    private String name;
    private int diameter;
    private double massToEarth;
    private double distanceFromSun;
    private int tempAdjective;
    private double speedSpace;
    private int satellites;

    @Override
    public String toString() {
        return "Planet{" + "name='" + name + '\''
                + ", diameter=" + diameter
                + ", massToEarth=" + massToEarth
                + ", distanceFromSun=" + distanceFromSun
                + ", tempAdjective=" + tempAdjective
                + ", speedSpace=" + speedSpace
                + ", satellites=" + satellites + '}';
    }

    static class Builder {
        private String name;
        private int diameter;
        private double massToEarth;
        private double distanceFromSun;
        private int tempAdjective;
        private double speedSpace;
        private int satellites;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildDiameter(int diameter) {
            this.diameter = diameter;
            return this;
        }

        Builder buildMassToEarth(double massToEarth) {
            this.massToEarth = massToEarth;
            return this;
        }

        Builder buildDistanceFromSun(double distanceFromSun) {
            this.distanceFromSun = distanceFromSun;
            return this;
        }

        Builder buildTempAdjective(int tempAdjective) {
            this.tempAdjective = tempAdjective;
            return this;
        }

        Builder buildSpeedSpace(double speedSpace) {
            this.speedSpace = speedSpace;
            return this;
        }

        Builder buildSatellites(int satellites) {
            this.satellites = satellites;
            return this;
        }

        Planet build() {
            Planet planet = new Planet();
            planet.name = name;
            planet.diameter = diameter;
            planet.massToEarth = massToEarth;
            planet.distanceFromSun = distanceFromSun;
            planet.tempAdjective = tempAdjective;
            planet.speedSpace = speedSpace;
            planet.satellites = satellites;
            return planet;
        }
    }

    public static void main(String[] args) {
        Planet planet = new Builder().buildName("Mars")
                .buildDiameter(6787)
                .buildMassToEarth(0.107)
                .buildDistanceFromSun(1.52)
                .buildTempAdjective(0)
                .buildSpeedSpace(5.02)
                .buildSatellites(2)
                .build();
        System.out.println(planet);
    }
}
