import React, { Component } from 'react';
import Axios from 'axios';

class Sensors extends Component {
  state = {
    sensors: [],
  };

  componentDidMount() {
    Axios.get('http://localhost:8080/getAllSensors')
      .then((res) => {
        console.log(res.data);
        this.setState({
          sensors: res.data,
        });
      })
      .catch((err) => console.error(err));
  }

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
            {this.state.sensors.map((sensor, i) => (
              <tr key={i}>
                <td data-label='Sensor ID'>{sensor.sensorID}</td>
                <td
                  style={{
                    backgroundColor:
                      sensor.sensorID !== 'S002' ? 'teal' : 'orange',
                  }}
                >
                  Active
                </td>
                <td>Roof Top</td>
                <td>7</td>
                <td>6</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default Sensors;
