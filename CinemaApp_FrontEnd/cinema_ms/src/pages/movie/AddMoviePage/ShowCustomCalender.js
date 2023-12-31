import {
  Calendar,
  Col,
  Radio,
  Row,
  Select,
  Typography,
  theme,
  Alert,
  TimePicker,
  Form,
  Button,
} from "antd";
import dayjs from "dayjs";
import "dayjs/locale/zh-cn";
import { useState } from "react";
import dayLocaleData from "dayjs/plugin/localeData";
dayjs.extend(dayLocaleData);


function ShowCustomCalendar(props) {
  const { token } = theme.useToken();
  const [date, setDate] = useState(new Date());
  const [oneshow, setOneshow] = useState(null);
  const [showArray, setShowArray] = useState([]);

  // const handleShowtime = (time, timeString) => {
  //   console.log("Selected Time:", time);
  //   console.log("Formatted Time:", timeString);
  //   setOneshow(timeString);
  // };

  // const addShow = () => {
  //   const newArray = [...showArray, oneshow];
  //   setShowArray(newArray);
  //   console.log(showArray);
  // };

  //   const onFinish = (values) => {
  //     console.log(values.showTime);
  //   };

  //   const onFinishFailed = () => {
  //     console.log("erro");
  //   };

  const onPanelChange = (value, mode) => {
    console.log(value.format("YYYY-MM-DD"));
    setDate(value.format("YYYY-MM-DD"));
  };
  const addShowDate = () => {
    const passData = {
      date: date,
      showTimeArray: showArray,
    };
    props.onDateChange(date);
  };

  const wrapperStyle = {
    width: 350,
    borderRadius: token.borderRadiusLG,
  };
  
const handleDateSelect = (date) => {
  console.log("Selected Date:", date.format("YYYY-MM-DD"));
  setDate(date.format("YYYY-MM-DD"));
};

  return (
    <div style={wrapperStyle}>
      <Calendar
        fullscreen={false}
        onSelect={handleDateSelect}
        headerRender={({ value, type, onChange, onTypeChange }) => {
          const start = 0;
          const end = 12;
          const monthOptions = [];
          let current = value.clone();
          const localeData = value.localeData();
          const months = [];
          for (let i = 0; i < 12; i++) {
            current = current.month(i);
            months.push(localeData.monthsShort(current));
          }
          for (let i = start; i < end; i++) {
            monthOptions.push(
              <Select.Option key={i} value={i} className="month-item">
                {months[i]}
              </Select.Option>
            );
          }
          const year = value.year();
          const month = value.month();
          const options = [];
          for (let i = year - 10; i < year + 10; i += 1) {
            options.push(
              <Select.Option key={i} value={i} className="year-item">
                {i}
              </Select.Option>
            );
          }

          return (
            <div
              style={{
                padding: 5,
              }}
            >
              <Row gutter={8}>
                <Col>
                  <Select
                    size="small"
                    dropdownMatchSelectWidth={false}
                    className="my-year-select"
                    value={year}
                    onChange={(newYear) => {
                      const now = value.clone().year(newYear);
                      onChange(now);
                    }}
                  >
                    {options}
                  </Select>
                </Col>
                <Col>
                  <Select
                    size="small"
                    dropdownMatchSelectWidth={false}
                    value={month}
                    onChange={(newMonth) => {
                      const now = value.clone().month(newMonth);
                      onChange(now);
                    }}
                  >
                    {monthOptions}
                  </Select>
                </Col>
              </Row>
            </div>
          );
        }}
        onPanelChange={onPanelChange}
      />
      <div>
        <Button onClick={addShowDate}>Add Date</Button>
      </div>
    </div>
  );
}
export default ShowCustomCalendar;
