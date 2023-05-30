import React from 'react'

function TimeAndLocation() {
  return (
    <div>
        <div className='flex item-center justify-center my-6'>
            <p className='text-white text-xl font-extralight'>
                Tuesday, 25, May 2023 | Local Time: 10:51 PM
            </p>

        </div>
        <div className='flex items-center justify-center my-3'>
            <p className='text-white text-3xl font-medium'>
                Fairfax, VA
            </p>
        
        </div>
    </div>
  );
}

export default TimeAndLocation