import com.gustav474.streamAPI.Impls.FillingRepositoryFromCodeImpl;
import com.gustav474.streamAPI.Impls.FilteringImpl;
import com.gustav474.streamAPI.Gender;
import com.gustav474.streamAPI.Impls.PaginatingImpl;
import com.gustav474.streamAPI.Impls.SortingImpl;
import com.gustav474.streamAPI.Exceptions.MoreThanTwoElementsException;
import com.gustav474.streamAPI.Person;
import com.gustav474.streamAPI.Repository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.*;

public class Maintest {
    Person person1 = new Person("Peter", Gender.MALE, LocalDate.of(1968, 5, 23));
    Person person2 = new Person("Jane", Gender.FEMALE, LocalDate.of(1985, 2, 12));
    Person person3 = new Person("Mark", Gender.MALE, LocalDate.of(1989, 5, 26));
    Person person4 = new Person("Alex", Gender.MALE, LocalDate.of(1993, 8, 17));
    Person person5 = new Person("Sam", Gender.MALE, LocalDate.of(1977, 10, 3));
    Person person6 = new Person("Rick", Gender.MALE, LocalDate.of(1957, 4, 1));
    Person person7 = new Person("Morty", Gender.MALE, LocalDate.of(2006, 8, 21));
    Person person8 = new Person("Harry", Gender.MALE, LocalDate.of(1990, 9, 19));
    Person person9 = new Person("Lila", Gender.FEMALE, LocalDate.of(1983, 6, 20));
    Person person10 = new Person("Hermes", Gender.MALE, LocalDate.of(1977, 2, 18));
    Person person11 = null;

    Repository<Person> repository = new Repository<>();
    List<Person> listOfPersons;

    @Before
    public void before() {
        listOfPersons  = new ArrayList<>();
        Collections.addAll(listOfPersons, person1, person2, person3, person4, person5, person6, person7, person8,
                person9, person10, person11);

        repository.setFilter(new FilteringImpl(repository));
        repository.setSorter(new SortingImpl(repository));
        repository.setPaginator(new PaginatingImpl(repository));
        repository.setFiller(new FillingRepositoryFromCodeImpl(repository));
        try {
            repository.getFiller().filling(listOfPersons);
        } catch (MoreThanTwoElementsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortingByNameDescending() {
        List<Person> sourceList = new ArrayList<>();
        Collections.addAll(sourceList, person1, person2, person3, person4, person5, person6, person7, person8,
                person9, person10);

        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person4, person8, person10, person2, person9, person3, person7, person1,
                person6, person5);

        List<Person> sortedRepository = repository.getSorter().sortingByNameDescending().getModifiedList();
        Assert.assertEquals(expectedList, sortedRepository);
        Assert.assertEquals(repository.getList(), sourceList);
    }

    @Test
    public void sortingByNameAscending() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person5, person6, person1, person7, person3, person9,
                person2, person10, person8, person4);

        repository.getSorter().sortingByNameAscending();
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void sortingByDateOfBirthFromNewestToOldest() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person7, person4, person8, person3, person2, person9,
                person5, person10, person1, person6);

        repository.getSorter().sortingByDateOfBirthFromNewestToOldest();
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void sortingByDateOfBirthFromOldestToNewest() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person6, person1, person10, person5, person9, person2,
                person3, person8, person4, person7);

        repository.getSorter().sortingByDateOfBirthFromOldestToNewest();
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void sortingByGenderMaleFemale() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person1, person3, person4, person5, person6, person7,
                person8, person10, person2, person9);

        repository.getSorter().sortingByGenderMaleFemale();
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void sortingByGenderFemaleMale() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person2, person9, person1, person3, person4, person5,
                person6, person7, person8, person10);

        repository.getSorter().sortingByGenderFemaleMale();
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void filteringByDateOfBirthAfter() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person2, person3, person4, person7, person8, person9);

        repository.getFilter().filteringByDateOfBirthAfter(LocalDate.of(1980, 1, 1));
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void filteringByDateOfBirthBefore() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person1, person5, person6, person10);

        repository.getFilter().filteringByDateOfBirthBefore(LocalDate.of(1980, 1, 1));
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void filteringByDateOfBirthEqual() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person3);

        repository.getFilter().filteringByDateOfBirthEqual(LocalDate.of(1989, 5, 26));
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void filteringByDateOfBirthEqualYear() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person3);

        repository.getFilter().filteringByDateOfBirthEqualYear(1989);
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void filteringByDateOfBirthEqualMonth() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person1, person3);

        repository.getFilter().filteringByDateOfBirthEqualMonth(05);
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void filteringByDateOfBirthEqualDay() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person3);

        repository.getFilter().filteringByDateOfBirthEqualDay(26);
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void filteringByNameEqual() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person3);

        repository.getFilter().filteringByNameEqual("Mark");
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void filteringByGender() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person2, person9);

        repository.getFilter().filteringByGender(Gender.FEMALE);
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void filteringAndSortingByGenderAndDateOfBirthAndName() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person3, person1);

        repository.getFilter().filteringByGender(Gender.MALE)
                .getFilter().filteringByDateOfBirthEqualMonth(05)
                .getSorter().sortingByNameDescending();
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void pagination() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person4, person5, person6);

        repository.getPaginator().pagination(3, 2);
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test
    public void paginationLastPage() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, person9, person10);

        repository.getPaginator().pagination(4, 3);
        Assert.assertEquals(expectedList, repository.getModifiedList());
    }

    @Test(expected = MoreThanTwoElementsException.class)
    public void ExceptionEmptyList() throws MoreThanTwoElementsException {
        List<Person> emptyList = new ArrayList<>();
        repository.getFiller().filling(emptyList);
    }

    @Test(expected = MoreThanTwoElementsException.class)
    public void ExceptionOneElementList() throws MoreThanTwoElementsException {
        List<Person> emptyList = new ArrayList<>();
        emptyList.add(person1);
        repository.getFiller().filling(emptyList);
    }
}
