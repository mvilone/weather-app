import React from 'react'
import { UilSearch, UilMap } from '@iconscout/react-unicons'


function Inputs() {
  return (
    <div className='flex flex-row justify-center my-6'> 
        <div className='flex flex-row w-3/4 items-center justify-center space-x-4'> 
          <input type="text" 
          placeholder='Choose a Location!'
          className='text-xl font-light p-2 w-full shadow-xl focus:outline-none capitalize text-center' 
          />
          <UilSearch size={25} className="text-white cursor-pointer transition ease-out hover:scale-125"/>
          <UilMap size={25} className="text-white cursor-pointertext-white cursor-pointer ease-out hover:scale-125"/>
        </div>
        <div 
            className="flex flex-row w-1/4 items-center justify-center">
                <button name = "metric" className='text-xl text-white font-medium'> ºC </button>
                <p className='text-white text-xl mx-1'>|</p>
                <button name='Imperial' className='text-xl text-white font-medium'> ºF </button>
        </div>

    </div>
  );
}

export default Inputs