import React from 'react'
import {
UilArrowUp,
UilArrowDown,
UilTemperature,
UilTear,
UilWind,
UilSun,
UilSunset,
} from "@iconscout/react-unicons"

function Details() {
  return (
    <div> 
        <div className='flex items-center justify-center py-6 text-xl text-cyan-300' >
            <p> Clear Skies </p>
        </div>
        <div className='flex flex-row items-center justify-between text-white py-3'>
            <img src="https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/1200px-Flag_of_the_United_States.svg.png"
            alt='' 
            className='w-20' />
            <p className='text-5xl'> 34º </p>
            <div className='flex flex-col space-y-2'>
                <div className='flex font-white text-small item-center justify-center'>
                    <UilTemperature size={18} className="mr-1"/>
                    Real feel: 
                    <span className='font-medium'> 32º </span>
                </div>

                <div className='flex font-white text-small item-center justify-center'>
                    <UilTear size={18} className="mr-1"/>
                    Humidity: 
                    <span className='font-medium ml-1'> 65% </span>
                </div>

                <div className='flex font-white text-small item-center justify-center'>
                    <UilWind size={18} className="mr-1"/>
                    Wind Speed: 
                    <span className='font-medium ml-1'> 11 m/h </span>
                </div>
            </div>
        </div>

        <div className='flex flex-row iterm-center justify-center space-x-2 text-white text-small py-3'>
            <UilSun />
            <p className='font-light'>Rise: 
                <span className=' font-medium'>11:44 AM
                </span>
            </p>
            <p className='font-light'>|</p>

            <UilSunset />
            <p className='font-light'>Set: 
                <span className=' font-medium '>11:44 PM
                </span>
            </p>
            <p className='font-light'>|</p>

            <UilArrowUp />
            <p className='font-light'>High: 
                <span className=' font-medium ml-1'>45º
                </span>
            </p>
            <p className='font-light'>|</p>

            <UilArrowDown />
            <p className='font-light'>Low: 
                <span className=' font-medium ml-1'>30º
                </span>
            </p>
            <p className='font-light'>|</p>
        </div>

    </div>
  );
}

export default Details