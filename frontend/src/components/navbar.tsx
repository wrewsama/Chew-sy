import React from 'react'
import { Link } from 'react-router-dom'

export default function MainNavbar() {
	return (
		<nav className="navbar navbar-dark navbar-expand">
			<div className="container-fluid">
				<Link to='/' className="navbar-brand">
					Chew-sy
				</Link>
			</div>
		</nav>
	)
} 
