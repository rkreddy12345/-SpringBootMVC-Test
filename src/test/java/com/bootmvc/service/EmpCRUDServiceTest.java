

package com.bootmvc.service;
import com.bootmvc.entity.Employee;
import com.bootmvc.repository.EmpCRUDRepository;
import org.junit.jupiter.api.*;
import org.mockito.*;
import java.util.Optional;

@TestInstance( TestInstance.Lifecycle.PER_CLASS)
public class EmpCRUDServiceTest {
    @Mock
    private EmpCRUDRepository empCRUDRepositoryMock;
    @InjectMocks
    private EmpCRUDServiceImpl empCRUDService;

    @BeforeAll
    public void setUpOnce(){
        MockitoAnnotations.openMocks (this );
    }

    @Test
    @DisplayName ( "get employee by ID" )
    public void getEmpByIdTest(){
        Mockito.when (empCRUDRepositoryMock.findById ( 132 )).thenReturn ( Optional.ofNullable (
                Employee.builder ().id ( 132 )
                        .name ( "Hari" )
                        .designation ( "ASE" )
                        .salary ( 30000f )
                        .deptNo ( "D1234" )
                        .status ( "A" ).build () ) );

        Assertions.assertEquals ( empCRUDService.getEmployeeByID ( 132 ),
                Employee.builder ().id ( 132 )
                        .name ( "Hari" )
                        .designation ( "ASE" )
                        .salary ( 30000f ).deptNo ( "D1234" )
                        .status ( "A" ).build ());
    }
}
