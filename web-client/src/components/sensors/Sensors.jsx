import React, { Component } from 'react';
import Axios from 'axios';

class Sensors extends Component {
  interval = null;
  state = {
    sensors: [],
  };

  componentDidMount() {
    this.interval = setInterval(this.getData, 40000);
    this.getData();
  }

  componentWillUnmount() {
    clearInterval(this.interval);
  }

  getData = () => {
    Axios.get('http://localhost:8080/getAllSensors')
      .then((res) => {
        console.log(res.data);
        this.setState({
          sensors: res.data,
        });
      })
      .catch((err) => console.error(err));
  };

  render() {
    return (
      <div className='ui container'>
        <table className='ui celled inverted grey table'>
          <thead>
            <tr>
              <th>Sensor ID</th>
              <th>Status</th>
              <th>Location</th>
              <th>Smoke Level</th>
              <th>
                CO<sub>2</sub> Level
              </th>
            </tr>
          </thead>
          <tbody>
            {this.state.sensors.map((sensorData, i) => (
              <tr
                key={i}
                style={{
                  backgroundColor:
                    sensorData.latestCO2Level > 5 ||
                    sensorData.latestSmokeLevel > 5
                      ? '#e84118'
                      : 'teal',
                }}
              >
                <td data-label='Sensor ID'>{sensorData.sensorID}</td>
                <td>{sensorData.status === true ? 'Active' : 'Deactivated'}</td>
                <td>
                  Floor No: {sensorData.floorNo}
                  <br /> Room No: {sensorData.roomNo}
                </td>
                <td>{sensorData.latestSmokeLevel}</td>
                <td>{sensorData.latestCO2Level}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default Sensors;
