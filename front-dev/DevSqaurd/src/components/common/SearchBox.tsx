import React from 'react';
import { TextField, InputAdornment, IconButton } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import ClearIcon from '@mui/icons-material/Clear';

const SearchBox = () => {
  const [searchTerm, setSearchTerm] = React.useState('');

  const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSearchTerm(event.target.value);
  };

  const handleClearSearch = () => {
    setSearchTerm('');
  };

  return (
    <TextField
      value={searchTerm}
      onChange={handleSearchChange}
      variant="outlined"
      placeholder="Type to search"
      InputProps={{
        startAdornment: (
          <InputAdornment position="start">
            <SearchIcon />
          </InputAdornment>
        ),
        endAdornment: (
          <InputAdornment position="end">
            {searchTerm && (
              <IconButton onClick={handleClearSearch}>
                <ClearIcon />
              </IconButton>
            )}
          </InputAdornment>
        ),
      }}
      fullWidth
      sx={{
        width: '300px',
        height: '30px',
        '& .MuiInputBase-input': {
          fontSize: '14px',
        },
        '& .MuiSvgIcon-root': {
          fontSize: '20px',
        },
        borderRadius: '16px'
      }}
    />
  );
};

export default SearchBox;
