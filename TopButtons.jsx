import React from 'react'

function TopButtons() {
  const cities = [
    {
        id:1,
        title: "London"
    },
    {
        id:2,
        title: "US"
    },
    {
        id:3,
        title: "Korea"
    },
    {
        id:4,
        title: "Asia"
    },
    {
        id:5,
        title: "Mexico"
    },
  ]
  
    return (
    <div className='flex items-center justify-around ny-6'>
        {cities.map((city) => (
        <button key={city.id} className='text-white text-lg font-medium'> {city.title}</button>
    ))}</div>
  );
}

export default TopButtons