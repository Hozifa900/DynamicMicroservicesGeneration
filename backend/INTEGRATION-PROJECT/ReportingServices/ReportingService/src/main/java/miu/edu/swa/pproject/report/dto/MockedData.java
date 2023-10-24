package miu.edu.swa.pproject.report.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MockedData {
    private LocalDate date;
    private String time;
    private Double Normalized_Sensitivity_Index;
    private String topic;

    public MockedData(LocalDate date, String time, String topic, Double Normalized_Sensitivity_Index) {
        this.date = date;
        this.time = time;
        this.Normalized_Sensitivity_Index = Normalized_Sensitivity_Index;
        this.topic = topic;
    }

    public static ArrayList<MockedData> generateMockedData() {
        List<MockedData> mocked = new ArrayList<>();
        mocked.add(new MockedData(LocalDate.of(2023, 10, 1), "11:00 AM", "NSI_3_5",
                0.75));
        mocked.add(new MockedData(LocalDate.of(2023, 10, 1), "10:00 AM", "NSI_1_2",
                0.85));
        mocked.add(new MockedData(LocalDate.of(2023, 10, 1), "08:00 PM", "NSI_1_7",
                0.43));
        mocked.add(new MockedData(LocalDate.of(2023, 10, 1), "09:00 PM", "NSI_1_7",
                0.43));
        mocked.add(new MockedData(LocalDate.of(2023, 10, 1), "10:00 PM", "NSI_1_7",
                0.43));
        mocked.add(new MockedData(LocalDate.of(2023, 10, 1), "11:00 PM", "NSI_1_7",
                0.43));
        mocked.add(new MockedData(LocalDate.of(2023, 10, 1), "12:00 PM", "NSI_1_7",
                0.43));
        return (ArrayList<MockedData>) mocked;
    }

}
