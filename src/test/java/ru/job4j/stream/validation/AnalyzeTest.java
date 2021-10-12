package ru.job4j.stream.validation;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.4.4.Контрольные вопросы
 * 2. Аттестация [#49777 #127086]test
 *
 * @author Dmitry
 * @version 1
 * @since 11.10.2021
 */
public class AnalyzeTest {

    @Test
    public void whenAverageScoreThen4D() {
        Stream<Pupil> stream = Stream.of(
                new Pupil("name1", List.of(
                        new Subject("mat", 2),
                        new Subject("geo", 3))),
                new Pupil("name2", List.of(
                        new Subject("fiz", 5),
                        new Subject("fil", 6)
                ))
        );
        double expected = 4D;
        double result = Analyze.averageScore(stream);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100)))
                )
        );
        assertThat(average, is(100D));
    }

    @Test
    public void whenPupilAverage() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100))),
                        new Pupil("Petrov",
                                List.of(new Subject("Math", 60)))
                )
        );
        assertThat(average, is(80D));
    }

    @Test
    public void whenAverageScoreBySubjectThenTuple() {
        Stream<Pupil> stream = Stream.of(
                new Pupil("name1", List.of(
                        new Subject("mat", 2),
                        new Subject("geo", 3))),
                new Pupil("name2", List.of(
                        new Subject("fiz", 5),
                        new Subject("fil", 6)
                ))
        );
        List<Tuple> expected = List.of(
                new Tuple("name1", 2.5D),
                new Tuple("name2", 5.5D)
        );
        List<Tuple> result = Analyze.averageScoreBySubject(stream);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListOfPupilAverage() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                Stream.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100),
                                        new Subject("Lang", 100))),
                        new Pupil("Petrov",
                                List.of(new Subject("Math", 60),
                                        new Subject("Lang", 60)))
                )
        );
        assertThat(average, is(List.of(
                new Tuple("Ivanov", 100D),
                new Tuple("Petrov", 60D)
        )));
    }

    @Test
    public void whenAverageScoreByPupilThenTupleName() {
        Stream<Pupil> stream = Stream.of(
                new Pupil("name1", List.of(
                        new Subject("mat", 2),
                        new Subject("geo", 4))),
                new Pupil("name2", List.of(
                        new Subject("mat", 4),
                        new Subject("geo", 6)
                ))
        );
        List<Tuple> expected = List.of(
                new Tuple("geo", 5),
                new Tuple("mat", 3)
        );
        List<Tuple> result = Analyze.averageScoreByPupil(stream);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListOfSubjectAverage() {
        List<Tuple> average = Analyze.averageScoreByPupil(
                Stream.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100),
                                        new Subject("Lang", 100))),
                        new Pupil("Petrov",
                                List.of(new Subject("Math", 60),
                                        new Subject("Lang", 60)))
                )
        );
        assertThat(average, is(List.of(
                new Tuple("Lang", 80D),
                new Tuple("Math", 80D)
        )));
    }

    @Test
    public void whenBestStudentThenNmae2score10() {
        Stream<Pupil> stream = Stream.of(
                new Pupil("name1", List.of(
                        new Subject("mat", 2),
                        new Subject("geo", 4))),
                new Pupil("name2", List.of(
                        new Subject("mat", 4),
                        new Subject("geo", 6)
                ))
        );
        Tuple expected = new Tuple("name2", 10);
        Tuple result = Analyze.bestStudent(stream);
        assertThat(result, is(expected));
    }

    @Test
    public void whenBestStudentThenIvanovScore200() {
        Tuple average = Analyze.bestStudent(
                Stream.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100),
                                        new Subject("Lang", 100))),
                        new Pupil("Petrov",
                                List.of(new Subject("Math", 60),
                                        new Subject("Lang", 60)))
                )
        );
        assertThat(average, is(new Tuple("Ivanov", 200D)));
    }

    @Test
    public void whenBestSubjectThenGeoScore10() {
        Stream<Pupil> stream = Stream.of(
                new Pupil("name1", List.of(
                        new Subject("mat", 2),
                        new Subject("geo", 4))),
                new Pupil("name2", List.of(
                        new Subject("mat", 4),
                        new Subject("geo", 6)
                ))
        );
        Tuple expected = new Tuple("geo", 10);
        Tuple result = Analyze.bestSubject(stream);
        assertThat(result, is(expected));
    }

    @Test
    public void whenBestSubjectThenMathScore160() {
        Tuple average = Analyze.bestSubject(
                Stream.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100),
                                        new Subject("Lang", 100))),
                        new Pupil("Petrov",
                                List.of(new Subject("Math", 60),
                                        new Subject("Lang", 30)))
                )
        );
        assertThat(average, is(new Tuple("Math", 160D)));
    }
}