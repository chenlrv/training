package General;

import java.time.LocalDateTime;
import java.util.HashMap;

public class SetGetSetAll {
    /* Requirements: implement a data structure that performs get(index), set(index, value) , setAll(value) in O(1)
    There are no limitations on memory space.
    For example:
    get(0)
    set(1, "a"),
    setAll("c")
    set(1,"b")
    get(1)
    setAll()
    get(1)


    I've implemented it using HashMap and a variable for setAll.
    All operations are O(1) (get and set are amortized O(1))
     */

    private ValueAndTimestamp setAllValue = null;
    private HashMap<Integer, ValueAndTimestamp> map = new HashMap<>();

    private void set(int index, String value) {
        map.put(index, new ValueAndTimestamp(value, LocalDateTime.now()));
    }

    private String get(int index) {
        ValueAndTimestamp valueAndTimestampInIndex = map.get(index);

        if (valueAndTimestampInIndex == null) {
            return setAllValue != null ? setAllValue.getValue() : null;
        }

        LocalDateTime timestampInIndex = valueAndTimestampInIndex.getTimestamp();
        if (setAllValue == null) {
            return valueAndTimestampInIndex.getValue();
        } else {
            return timestampInIndex.isAfter(setAllValue.getTimestamp()) ?
                    valueAndTimestampInIndex.getValue() : setAllValue.getValue();
        }
    }

    private void setAll(String value) {
        setAllValue = new ValueAndTimestamp(value, LocalDateTime.now());
    }


    private class ValueAndTimestamp {
        private final String value;
        private final LocalDateTime timestamp;

        public ValueAndTimestamp(String value, LocalDateTime timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public String getValue() {
            return value;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }
}
