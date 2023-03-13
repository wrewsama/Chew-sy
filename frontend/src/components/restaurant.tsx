import { useState } from 'react'
import DataService from '../api/api'

type Restaurant = {
	id: String;
	sessionId: String;
	name: String;
}

export default function Restaurant(props: { restaurant: Restaurant, callback: Function }) {
	const [deleteButtonStyle, setDeleteButtonStyle] = useState({ display: 'none' })
	const [itemClass, setItemClass] = useState('')

	const handleMouseEnter: React.MouseEventHandler<HTMLElement> = event => {
		setDeleteButtonStyle({ display: 'block' })
		setItemClass('list-group-item-primary')
	}

	const handleMouseLeave: React.MouseEventHandler<HTMLElement> = event => {
		setDeleteButtonStyle({ display: 'none' })
		setItemClass('')
	}

	const handleDeleteButtonClick: React.MouseEventHandler<HTMLElement> = event => {
		DataService.deleteRestaurant(props.restaurant.id)
			.then(res => {
				props.callback()
			})
			.catch(e => {
				console.error(e)
			})
	}

	return (
		<li className={`list-group-item d-flex ${itemClass}`}
		    onMouseEnter={handleMouseEnter}
			onMouseLeave={handleMouseLeave}>
			{props.restaurant.name}

			<button type='button'
					style={deleteButtonStyle}
			        className='btn-close ms-auto'
					onClick={handleDeleteButtonClick} />
		</li>
	)
}
