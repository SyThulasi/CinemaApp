import React, { useState } from "react";
import { TimePicker, Button } from "antd";

function ShowTimes(props) {
  const [oneshow, setOneshow] = useState(""); // Initialize with an empty string
  const [showArray, setShowArray] = useState([]);

  const handleShowtime = (time, timeString) => {
    console.log("Selected Time:", time);
    console.log("Formatted Time:", timeString);
    setOneshow(timeString);
  };

  const addShow = () => {
    const newArray = [...showArray, oneshow];
    setShowArray(newArray);
    console.log(showArray);
  };

  const addShowDate = () => {
    // Do something with the selected time(s) and date here
  };

  const wrapperStyle = {
    width: 300,
    borderRadius: "10px", // Assuming token.borderRadiusLG is a string like "10px"
  };

  return (
    <div style={wrapperStyle}>
      <TimePicker onChange={handleShowtime} />
      <div>
        <Button onClick={addShow}>Add show</Button>
      </div>
    </div>
  );
}

export default ShowTimes;
