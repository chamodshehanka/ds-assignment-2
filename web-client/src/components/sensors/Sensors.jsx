import React, { Component } from 'react';
import Axios from 'axios';

class Sensors extends Component {
  state = {
    sensors: [],
  };

  componentDidMount() {
    Axios.get('http://localhost:8080/getAllSensors')
      .then((res) => {
        this.setState({
          sensors: [res.data],
        });
      })
      .catch((err) => console.error(err));
  }

  render() {
    return (
      <div className='container'>
        <table className='ui celled table'>
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
            <tr>
              <td data-label='Name'>James</td>
              <td data-label='Age'>24</td>
              <td data-label='Job'>Engineer</td>
            </tr>
            <tr>
              <td data-label='Name'>Jill</td>
              <td data-label='Age'>26</td>
              <td data-label='Job'>Engineer</td>
            </tr>
            <tr>
              <td data-label='Name'>Elyse</td>
              <td data-label='Age'>24</td>
              <td data-label='Job'>Designer</td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
}

export default Sensors;
