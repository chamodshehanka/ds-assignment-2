import React, { Component } from 'react';

class Header extends Component {
  state = {};
  render() {
    return (
      <header>
        <div className='ui blue inverted menu'>
          <div className='header item'>FAMS Web </div>
          <a className='item' href='!#'>
            About Us
          </a>
          <a className='item' href='!#'>
            Sensors
          </a>
          <a className='item' href='!#'>
            Locations
          </a>
        </div>
      </header>
    );
  }
}

export default Header;
