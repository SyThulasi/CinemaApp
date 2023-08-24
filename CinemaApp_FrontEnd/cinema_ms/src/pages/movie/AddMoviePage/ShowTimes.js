import React, { useState } from "react";
import { TimePicker, Button } from "antd";

function ShowTimes(props) {
  
  const [oneshow, setOneshow] = useState("");
  const [showArray, setShowArray] = useState([]);

  const handleShowtime = (time, timeString) => {
    console.log("Selected Time:", time);
    console.log("Formatted Time:", timeString);
    setOneshow(timeString);
  };

const addShow = () => {
  const newArray = [...showArray, oneshow];
  setShowArray(newArray);
  console.log(newArray);
};

  const wrapperStyle = {
    width: 300,
    borderRadius: "10px",
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
