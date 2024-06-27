package com.carservice.web.view.controllers;

import com.carservice.dto.AppointmentDTO;
import com.carservice.exceptions.AppointmentNotFoundException;
import com.carservice.exceptions.CustomerNotFoundException;
import com.carservice.services.AppointmentService;
import com.carservice.web.view.models.AppointmentViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@AllArgsConstructor
@RequestMapping("/appointments")
public class AppointmentViewController {
	private final AppointmentService appointmentService;
	private final ModelMapper modelMapper;

	private AppointmentViewModel convertToAppointmentViewModel(AppointmentDTO appointmentDTO) {
		return modelMapper.map(appointmentDTO, AppointmentViewModel.class);
	}

	@GetMapping
	public String showAppointments(Model model) {
		final List<AppointmentViewModel> appointments = appointmentService.allAppointments().stream()
				.map(this::convertToAppointmentViewModel).collect(toList());
		model.addAttribute("appointments", appointments);
		return "/appointments/appointments";
	}

	@PostMapping("/create")
	public String createAppointment(@Valid @ModelAttribute("appointment") AppointmentViewModel appointment, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/appointments";
		}
		appointmentService.create(modelMapper.map(appointment, AppointmentDTO.class));
		return "redirect:/appointments";
	}

	@GetMapping("/appointments-by-customer-email/{customerEmail}")
	public String getAppointmentsByCustomer(@PathVariable("customerEmail") String customerEmail, Model model) {
		final List<AppointmentViewModel> appointments = appointmentService.findAppointmentsByCustomerEmail(customerEmail)
				.stream()
				.map(this::convertToAppointmentViewModel)
				.collect(toList());
		model.addAttribute("appointments", appointments);
		return "/appointments/appointments";
	}

	@GetMapping("/appointments-by-date-created/{dateCreated}")
	public String getAppointmentsByDateCreated(@PathVariable("dateCreated") LocalDate dateCreated, Model model) {
		final List<AppointmentViewModel> appointments = appointmentService.findAppointmentsByDateCreated(dateCreated)
				.stream()
				.map(this::convertToAppointmentViewModel)
				.collect(toList());
		model.addAttribute("appontments", appointments);
		return "/appointments/appointments";
	}

	@GetMapping("/appointments-by-date-of-appointment/{dateOfAppointment}")
	public String getAppointmentsByDateOfAppointment(@PathVariable("dateOfAppointment") LocalDate dateOfAppointment, Model model) {
		final List<AppointmentViewModel> appointments = appointmentService.findAppointmentsByDateOfAppointment(dateOfAppointment)
				.stream()
				.map(this::convertToAppointmentViewModel)
				.collect(toList());
		model.addAttribute("appointments", appointments);
		return "/appointments/appointments";
	}

	@GetMapping("/passed-appointments")
	public String getPassedAppointments(Model model) {
		final List<AppointmentViewModel> appointments = appointmentService.findPassedAppointments()
				.stream()
				.map(this::convertToAppointmentViewModel)
				.collect(toList());
		model.addAttribute("appointments", appointments);
		return "/appointments/appointments";
	}

	@GetMapping("/ongoing-appointments")
	public String getOngoingAppointments(Model model) {
		final List<AppointmentViewModel> appointments = appointmentService.findOngoingAppointments()
				.stream()
				.map(this::convertToAppointmentViewModel)
				.collect(toList());
		model.addAttribute("appointments", appointments);
		return "/appointments/appointments";
	}

	@GetMapping("/delete-appointment/{id}")
	public String deleteAppointment(@PathVariable("id") int id) {
		appointmentService.deleteAppointment(id);
		return "redirect:/appointments";
	}

	@ExceptionHandler({AppointmentNotFoundException.class, CustomerNotFoundException.class})
	public String handleException(AppointmentNotFoundException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		return "/error/appointment-errors";
	}
}
